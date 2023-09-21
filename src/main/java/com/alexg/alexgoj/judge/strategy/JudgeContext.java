package com.alexg.alexgoj.judge.strategy;

import com.alexg.alexgoj.model.dto.question.JudgeCase;
import com.alexg.alexgoj.judge.codesandbox.model.JudgeInfo;
import com.alexg.alexgoj.model.entity.Question;
import com.alexg.alexgoj.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * 上下文（用于定义在策略中传递的参数）
 */
@Data
public class JudgeContext {

    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private List<JudgeCase> judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;

}
