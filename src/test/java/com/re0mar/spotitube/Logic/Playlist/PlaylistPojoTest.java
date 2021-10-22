package com.re0mar.spotitube.Logic.Playlist;

import com.openpojo.reflection.PojoClassFilter;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import org.junit.jupiter.api.Test;

public class PlaylistPojoTest {
    // The package to be tested
    private final String packageName = "com.re0mar.spotitube.Logic.Playlist";

    @Test
    public void validate() {
        Validator validator = ValidatorBuilder.create()
                .with(new SetterMustExistRule(),
                        new GetterMustExistRule())
                .with(new SetterTester(),
                        new GetterTester())
                .build();

        PojoClassFilter pojoClassFilter = pojoClass -> pojoClass.getName().endsWith("list");
        validator.validate(packageName, pojoClassFilter);
    }
}
