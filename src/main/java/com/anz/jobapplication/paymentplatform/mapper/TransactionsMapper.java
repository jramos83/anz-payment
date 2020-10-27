package com.anz.jobapplication.paymentplatform.mapper;

import com.anz.jobapplication.paymentplatform.domain.Transaction;
import com.anz.jobapplication.paymentplatform.response.ListTransactionsResponse;
import com.anz.jobapplication.paymentplatform.response.TransactionsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionsMapper {

    List<TransactionsResponse> map(List<Transaction> transactions);

    @Mappings({
            @Mapping(source = "account", target = "account")
    })
    TransactionsResponse map(Transaction transaction);
}
