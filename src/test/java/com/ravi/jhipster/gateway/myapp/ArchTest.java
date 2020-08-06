package com.ravi.jhipster.gateway.myapp;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.ravi.jhipster.gateway.myapp");

        noClasses()
            .that()
            .resideInAnyPackage("com.ravi.jhipster.gateway.myapp.service..")
            .or()
            .resideInAnyPackage("com.ravi.jhipster.gateway.myapp.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..com.ravi.jhipster.gateway.myapp.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
