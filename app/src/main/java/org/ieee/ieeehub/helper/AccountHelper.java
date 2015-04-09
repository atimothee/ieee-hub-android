package org.ieee.ieeehub.helper;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.util.Log;

import org.ieee.ieeehub.R;

/**
 * Created by Timo on 4/6/15.
 */
public class AccountHelper {
    private Context mContext;
    private String accountType;
    private String accountName;
    private static final String LOG_TAG = AccountHelper.class.getSimpleName();

    public AccountHelper(Context mContext){
        this.mContext = mContext;
        this.accountName = mContext.getString(R.string.account_name);
        this.accountType = mContext.getString(R.string.account_type);
    }

    public Account CreateSyncAccount() {
        Account newAccount = new Account(
                accountName, accountType);
        AccountManager accountManager =
                (AccountManager) mContext.getSystemService(
                        mContext.ACCOUNT_SERVICE);

        if (accountManager.addAccountExplicitly(newAccount, null, null)) {
            return newAccount;
        } else {
            Log.e(LOG_TAG, "Account exists or some other error occured");
        }
        return null;

    }
}
