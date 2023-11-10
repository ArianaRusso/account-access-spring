package br.com.arianarusso.accountaccess.mappers;

import br.com.arianarusso.accountaccess.dtos.AccountRegistrationDto;
import br.com.arianarusso.accountaccess.entities.Account;
import br.com.arianarusso.accountaccess.entities.Address;
import br.com.arianarusso.accountaccess.entities.Customer;

public class AccountRegistrationMapper{

    public static Account dtoToEntity (AccountRegistrationDto dto){
        Address address = Address.builder()
                .postalCode(dto.postalCode())
                .street(dto.street())
                .number(dto.number())
                .complement(dto.complement())
                .city(dto.city())
                .state(dto.state())
                .country(dto.country())
                .build();

        Customer customer = Customer.builder()
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .document(dto.document())
                .address(address)
                .build();

        return new Account(customer);
    }
}
