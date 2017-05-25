package by.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataBaseSetter implements CommandLineRunner {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void run(String... strings) throws Exception {
        accountRepository.deleteAll();
        clientRepository.deleteAll();
        Client client = new Client("test", 27);
        Account account = new Account(22, "testaccount", client);
        List<Account> accounts = new ArrayList<>();
        accounts.add(account);
        client.setAccounts(accounts);
        clientRepository.save(client);
        accountRepository.save(accounts);

    }
}
