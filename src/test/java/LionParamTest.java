import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class LionTestParam {

    @Mock
    Feline feline;
    private final String sex;
    private final boolean result;

    public LionTestParam(String sex, boolean result) {
        this.sex = sex;
        this.result = result;
    }

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Parameterized.Parameters
    public static Object[][] getHasMane() {
        return new Object[][]{
                {"Самка", false},
                {"Самец", true},
        };
    }

    @Test
    public void doesHaveManeParamTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(result, lion.doesHaveMane());

    }
}