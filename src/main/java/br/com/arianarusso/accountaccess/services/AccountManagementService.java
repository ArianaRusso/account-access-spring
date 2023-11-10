package br.com.arianarusso.accountaccess.services;
import br.com.arianarusso.accountaccess.dtos.AccountRegistrationDto;
import br.com.arianarusso.accountaccess.entities.Account;
import br.com.arianarusso.accountaccess.entities.Address;
import br.com.arianarusso.accountaccess.entities.Customer;
import br.com.arianarusso.accountaccess.exceptions.BusinessRuleException;
import br.com.arianarusso.accountaccess.mappers.AccountRegistrationMapper;
import br.com.arianarusso.accountaccess.repositories.AccountRespository;
import br.com.arianarusso.accountaccess.repositories.AddressRepository;
import br.com.arianarusso.accountaccess.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountManagementService {

    @Autowired
    private AccountRespository accountRespository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public void createAccount(AccountRegistrationDto dto){

        Account account = AccountRegistrationMapper.dtoToEntity(dto);
        Customer customer = account.getCustomer();
        Address address = customer.getAddress();

        Address savedAddress = addressRepository.save(address);
        customer.setAddress(savedAddress);

        Customer savedCustomer = customerRepository.save(customer);
        account.setCustomer(savedCustomer);

        accountRespository.save(account);
    }

    public void closeAccount(int accountNumber){
        Account account= accountRespository.findByNumber(accountNumber).orElseThrow(
                () -> new BusinessRuleException("Account not found")
        );
        accountRespository.delete(account);
    }
}
