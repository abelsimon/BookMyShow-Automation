package DataProviders;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class ParametrizationClass {

    @DataProvider(name = "getdata")
    public static Object[][] dataProvFunc(Method mtd) {

        Object newobject[][] = null;


        if (mtd.getName().equalsIgnoreCase("movieSearch")) {

            newobject = new Object[2][2];
            newobject[0][0] = "Fantasy Island";
            newobject[0][1] = "Movie Search_PositiveScenario";

            newobject[1][0] = "12345678";
            newobject[1][1] = "Movie Search_NegativeScenario";

        }
        else if (mtd.getName().equalsIgnoreCase("castCrew")) {

            newobject = new Object[2][4];
            newobject[0][0] = "Tom Holland";
            newobject[0][1] = "Mychael Danna";
            newobject[0][2] = "Onward";
            newobject[0][3] = "CastCrew_PositiveScenario";

            newobject[1][0] = "Tom Cruise";
            newobject[1][1] = "Michael Jackson";
            newobject[1][2] = "Onward";
            newobject[1][3] = "CastCrew_NegativeScenario";
        }

        return newobject;
    }

  /*  @DataProvider(name = "moviepositive")
    public static Object[][] dataProvFunction()
    {
        return new Object[][]
                {

                        {"Fantasy Island"}
                };

    } */
}

