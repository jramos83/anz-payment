package com.anz.jobapplication.paymentplatform.mapper;

import com.anz.jobapplication.paymentplatform.domain.Account;
import com.anz.jobapplication.paymentplatform.response.AccountsResponse;
import com.anz.jobapplication.paymentplatform.response.ListAccountsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountsMapper {

    public List<AccountsResponse> map(List<Account> accounts);

    public AccountsResponse map(Account account);

}
