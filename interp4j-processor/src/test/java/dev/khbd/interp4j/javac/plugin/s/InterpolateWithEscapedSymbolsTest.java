package dev.khbd.interp4j.javac.plugin.s;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Sergei_Khadanovich
 */
public class InterpolateWithEscapedSymbolsTest extends AbstractPluginTest {

    @Test(dataProvider = "optionsDataProvider")
    public void interpolate_stringLiteralWithEscapedSymbols_interpolate(PluginOptions options) throws Exception {
        String source = """
                package cases.escaped_symbols;
                
                import static dev.khbd.interp4j.core.Interpolations.s;
                
                public class Main {
                
                    public static String greet() {
                        String name = "Alex";
                        return s("Hello, \\"\\"$name\\"\\"");
                    }
                }
                """;

        CompilationResult result = compiler.compile(options, "cases/escaped_symbols/Main.java", source);

        assertThat(result.isSuccess()).isTrue();

        ClassLoader classLoader = result.getClassLoader();
        Class<?> clazz = classLoader.loadClass("cases.escaped_symbols.Main");
        Method method = clazz.getMethod("greet");
        String greet = (String) method.invoke(null);

        assertThat(greet).isEqualTo("Hello, \"\"Alex\"\"");
    }

}
