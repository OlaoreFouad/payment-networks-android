package dev.olaore.paymentnetworks.payments;

import static org.mockito.ArgumentMatchers.any;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import dev.olaore.paymentnetworks.data.common.Status;
import dev.olaore.paymentnetworks.data.models.payments.network.NetworkPaymentMethods;
import dev.olaore.paymentnetworks.data.remote.PaymentMethodsService;
import dev.olaore.paymentnetworks.data.remote.payments.PaymentsApiHelper;
import dev.olaore.paymentnetworks.ui.payments.repos.PaymentMethodsRepository;
import dev.olaore.paymentnetworks.ui.payments.viewmodels.PaymentMethodsViewModel;
import dev.olaore.paymentnetworks.util.TestUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@RunWith(MockitoJUnitRunner.class)
public class PaymentMethodsViewModelTest {

    @Rule
    public InstantTaskExecutorRule rule = new InstantTaskExecutorRule();

    public PaymentMethodsRepository paymentMethodsRepository;
    public PaymentsApiHelper paymentsApiHelper;

    @Mock
    public PaymentMethodsService paymentMethodsService;

    private PaymentMethodsViewModel viewModel;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);

        this.paymentsApiHelper = new PaymentsApiHelper(this.paymentMethodsService);
        this.paymentMethodsRepository = new PaymentMethodsRepository(this.paymentsApiHelper);

        viewModel = new PaymentMethodsViewModel(this.paymentMethodsRepository);
    }

    @Test
    public void shouldReturn_ListOfPaymentMethods_WithSuccessStatus() throws IOException {
        // arrange
        NetworkPaymentMethods expectedPaymentMethods = Mockito.mock(NetworkPaymentMethods.class);
        Mockito.when(expectedPaymentMethods.toDomainPaymentMethods()).thenReturn(TestUtils.PAYMENT_METHODS);

        Response<NetworkPaymentMethods> expectedPaymentMethodsResponse = Response.success(expectedPaymentMethods);
        Call expectedPaymentMethodsCall = Mockito.mock(Call.class);

        Mockito.when(this.paymentMethodsService.getPaymentMethods()).thenReturn(expectedPaymentMethodsCall);

        Mockito.doAnswer(invocation -> {
            Callback<NetworkPaymentMethods> callback = invocation.getArgument(0, Callback.class);
            callback.onResponse(expectedPaymentMethodsCall, expectedPaymentMethodsResponse);
            return null;
        }).when(expectedPaymentMethodsCall).enqueue(any(Callback.class));

        // act
        viewModel.getPaymentMethods();

        viewModel.paymentMethods().observeForever((result) -> {
            // assert
            Mockito.verify(paymentMethodsService, Mockito.times(1)).getPaymentMethods();
            Assert.assertEquals(result.getStatus(), Status.SUCCESS);
            Assert.assertEquals(result.getData().size(), TestUtils.PAYMENT_METHODS.size());
        });

    }

    @Test
    public void shouldReturn_Error_WithErrorStatus() {
        // arrange
        Response<NetworkPaymentMethods> expectedPaymentMethodsResponse = Response.error(500, TestUtils.ERROR_RESPONSE);
        Call expectedPaymentMethodsCall = Mockito.mock(Call.class);

        Mockito.when(this.paymentMethodsService.getPaymentMethods()).thenReturn(expectedPaymentMethodsCall);

        Mockito.doAnswer(invocation -> {
            Callback<NetworkPaymentMethods> callback = invocation.getArgument(0, Callback.class);
            callback.onResponse(expectedPaymentMethodsCall, expectedPaymentMethodsResponse);
            return null;
        }).when(expectedPaymentMethodsCall).enqueue(any(Callback.class));

        // act
        viewModel.getPaymentMethods();

        viewModel.paymentMethods().observeForever((result) -> {
            // assert
            Mockito.verify(paymentMethodsService, Mockito.times(1)).getPaymentMethods();
            Assert.assertEquals(result.getStatus(), Status.ERROR);
        });
    }

}
