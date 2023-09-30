package ua.javarush.kim.quest.repository.json;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.javarush.kim.quest.entity.Game;
import ua.javarush.kim.quest.entity.Question;
import ua.javarush.kim.quest.repository.QuestionRepo;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class QuestionRepoImpl implements QuestionRepo {
    private static final Logger LOG = LoggerFactory.getLogger(QuestionRepoImpl.class);


    private final Map<Long, Question> mapOfQuestions;

    public QuestionRepoImpl(InputStream jsonFileInputStream) {
        Game game = null;
        try {
            // Создайте объект Gson
            Gson gson = new Gson();
            // Чтение JSON из InputStream
            game = gson.fromJson(new InputStreamReader(jsonFileInputStream), Game.class);
        } catch (JsonSyntaxException | JsonIOException e) {
            LOG.error("Can not get a game from JSON file", e);
//            throw new SourceException("Can not get game", e);
        }
        mapOfQuestions = game != null ? game.getQuestions()
                .stream()
                .collect(Collectors.toMap(Question::getId, Function.identity())) : null;

    }

    @Override
    public Question getQuestionWithAnswersbyId(Long questionId){
        return mapOfQuestions.get(questionId);
    }
}
