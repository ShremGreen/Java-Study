package affair.service;

import affair.DAO.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountService {
    //注入dao
    @Autowired
    private AccountDAO accountDAO;

    public void accountMoney() {
        accountDAO.delMoney();
        accountDAO.addMoney();
    }
}
