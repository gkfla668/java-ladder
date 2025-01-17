import model.Validator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidatorTest {
    @Test
    void 플레이어_이름의_길이가_기준을_넘은_경우() {
        //given
        String[] names = {"ha", "jinhee", "doo"};

        //when
        boolean result = Validator.isValidPlayerNameLength(names);

        //then
        assertThat(result).isFalse();
    }

    @Test
    void 플레이어_이름의_길이가_기준을_넘지않는_경우() {
        //given
        String[] names = {"ha", "jin", "dowon"};

        //when
        boolean result = Validator.isValidPlayerNameLength(names);

        //then
        assertThat(result).isTrue();
    }

    @Test
    void 플레이어_수가_두명_이상인_경우() {
        //given
        String[] names = {"ha", "jin", "dowon"};

        //when
        boolean result = Validator.isValidPlayerCount(names);

        //then
        assertThat(result).isTrue();
    }

    @Test
    void 플레이어_수가_두명_미만인_경우() {
        //given
        String[] names = {"halim"};

        //when
        boolean result = Validator.isValidPlayerCount(names);

        //then
        assertThat(result).isFalse();
    }

    @Test
    void 실행_결과의_수가_플레이어_수와_같은_경우() {
        //given
        int prizesCount = 5;
        int playersCount = 5;

        //when
        boolean result = Validator.isValidPrizeCount(prizesCount, playersCount);

        //then
        assertThat(result).isTrue();
    }

    @Test
    void 실행_결과의_수가_플레이어_수와_다른_경우() {
        //given
        int prizesCount = 5;
        int playersCount = 3;

        //when
        boolean result = Validator.isValidPrizeCount(prizesCount, playersCount);

        //then
        assertThat(result).isFalse();
    }
}
