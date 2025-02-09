package com.pikachu.record.sql.data;

import com.pikachu.record.sql.table.Account;
import com.pikachu.record.sql.table.AppOne;
import com.pikachu.record.sql.table.CountDown;
import com.pikachu.record.sql.table.Diary;
import com.pikachu.record.sql.table.Mood;
import com.pikachu.record.sql.table.Task;
import java.util.Map;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig accountDaoConfig;
    private final DaoConfig appOneDaoConfig;
    private final DaoConfig countDownDaoConfig;
    private final DaoConfig diaryDaoConfig;
    private final DaoConfig moodDaoConfig;
    private final DaoConfig taskDaoConfig;

    private final AccountDao accountDao;
    private final AppOneDao appOneDao;
    private final CountDownDao countDownDao;
    private final DiaryDao diaryDao;
    private final MoodDao moodDao;
    private final TaskDao taskDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        accountDaoConfig = daoConfigMap.get(AccountDao.class).clone();
        accountDaoConfig.initIdentityScope(type);

        appOneDaoConfig = daoConfigMap.get(AppOneDao.class).clone();
        appOneDaoConfig.initIdentityScope(type);

        countDownDaoConfig = daoConfigMap.get(CountDownDao.class).clone();
        countDownDaoConfig.initIdentityScope(type);

        diaryDaoConfig = daoConfigMap.get(DiaryDao.class).clone();
        diaryDaoConfig.initIdentityScope(type);

        moodDaoConfig = daoConfigMap.get(MoodDao.class).clone();
        moodDaoConfig.initIdentityScope(type);

        taskDaoConfig = daoConfigMap.get(TaskDao.class).clone();
        taskDaoConfig.initIdentityScope(type);

        accountDao = new AccountDao(accountDaoConfig, this);
        appOneDao = new AppOneDao(appOneDaoConfig, this);
        countDownDao = new CountDownDao(countDownDaoConfig, this);
        diaryDao = new DiaryDao(diaryDaoConfig, this);
        moodDao = new MoodDao(moodDaoConfig, this);
        taskDao = new TaskDao(taskDaoConfig, this);

        registerDao(Account.class, accountDao);
        registerDao(AppOne.class, appOneDao);
        registerDao(CountDown.class, countDownDao);
        registerDao(Diary.class, diaryDao);
        registerDao(Mood.class, moodDao);
        registerDao(Task.class, taskDao);
    }
    
    public void clear() {
        accountDaoConfig.clearIdentityScope();
        appOneDaoConfig.clearIdentityScope();
        countDownDaoConfig.clearIdentityScope();
        diaryDaoConfig.clearIdentityScope();
        moodDaoConfig.clearIdentityScope();
        taskDaoConfig.clearIdentityScope();
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public AppOneDao getAppOneDao() {
        return appOneDao;
    }

    public CountDownDao getCountDownDao() {
        return countDownDao;
    }

    public DiaryDao getDiaryDao() {
        return diaryDao;
    }

    public MoodDao getMoodDao() {
        return moodDao;
    }

    public TaskDao getTaskDao() {
        return taskDao;
    }

}
