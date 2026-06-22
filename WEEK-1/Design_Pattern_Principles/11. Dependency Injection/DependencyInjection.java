public class DependencyInjection {

    // Repository Interface

    interface CustomerRepository {

        String findCustomerById(int id);
    }

    // Concrete Repository

    static class CustomerRepositoryImpl
            implements CustomerRepository {

        public String findCustomerById(
                int id) {

            return "Customer ID: "
                    + id
                    + ", Name: Sravya";
        }
    }

    // Service Class

    static class CustomerService {

        private CustomerRepository repository;

        // Constructor Injection

        public CustomerService(
                CustomerRepository repository) {

            this.repository = repository;
        }

        public void getCustomer(
                int id) {

            System.out.println(

                    repository.findCustomerById(id)

            );
        }
    }

    // Main Method

    public static void main(
            String[] args) {

        CustomerRepository repository =

                new CustomerRepositoryImpl();

        CustomerService service =

                new CustomerService(
                        repository);

        service.getCustomer(101);
    }
}