package br.com.arianarusso.accountaccess.mappers;

import br.com.arianarusso.accountaccess.dtos.AccountRegistrationDto;
import br.com.arianarusso.accountaccess.entities.Account;
import br.com.arianarusso.accountaccess.entities.Address;
import br.com.arianarusso.accountaccess.entities.Customer;

public class AccountRegistrationMapper{

    public static Account dtoToEntity (AccountRegistrationDto dto){
        Address address = new Address(
                null, dto.postalCode(),
                dto.street(),
                dto.number(),
                dto.complement(),
                dto.city(),
                dto.state(),
                dto.country());
        Customer customer = new Customer(
                null,
                dto.firstName(),
                dto.lastName(),
                dto.document(),
                address);
        return new Account (customer);
    }
}
