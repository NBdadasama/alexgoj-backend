package com.alexg.alexgoj.judge;

import com.alexg.alexgoj.judge.strategy.DefaultJudgeStrategy;
import com.alexg.alexgoj.judge.strategy.JavaLanguageJudgeStrategy;
import com.alexg.alexgoj.judge.strategy.JudgeContext;
import com.alexg.alexgoj.judge.strategy.JudgeStrategy;
import com.alexg.alexgoj.judge.codesandbox.model.JudgeInfo;
import com.alexg.alexgoj.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}
