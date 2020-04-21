package com.itzjx.service;

import com.itzjx.domain.Account;

import java.util.List;

/**
 * 账户的service层接口
 */
public interface AccountService {
    /**
     * 查询所有
     * @return
     */
    public List<Account> findAll();
    /**
     * 保存账户信息
     * @param account
     */
    public void saveAccount(Account account);
}
