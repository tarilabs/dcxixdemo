package org.kie.kogito.queries;

import java.math.BigDecimal;

import dcxixdemo.utils.HttpUtils;
import io.quarkus.runtime.annotations.RegisterForReflection;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;

@RegisterForReflection
public class DTIServiceUtils {

    private DTIServiceUtils() {
        // no constrcut.
    }

    public static double dti(BigDecimal age) {
        String result = HttpUtils.post("LenderAcceptableDTI", "{\n" +
                                                              "    \"adultAge\": 18,\n" +
                                                              "    \"persons\": [\n" +
                                                              "        {\n" +
                                                              "            \"name\": \"<anonymous>\",\n" +
                                                              "            \"age\": " + age + "\n" +
                                                              "        }\n" +
                                                              "    ]\n" +
                                                              "}");
        JsonArray decodeValue = (JsonArray) Json.decodeValue(result);
        Double dti = decodeValue.getJsonObject(0).getDouble("$dti");
        System.out.println(dti);
        return dti;
    }
}
