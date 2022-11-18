- Cucumber + POM pattern + Junit framework
- Allure report, cucumber report, extent report
- Send mail after run test

### Config env IDE
- Edit Configurations: Cucumber Java
- Main class: io.cucumber.core.cli.Main
- Glue: Steps

### Run by CLI

`mvn clean test `

### Run with opstions
`mvn test -Dcucumber.options="...."`

### Run specific feature
`mvn test -Dcucumber.options="src/test/resources/Google.feature"`

### Run specific scenario
`mvn test -Dcucumber.options="src/test/resources/Google.feature:3"`

### Run with tags
`mvn test -Dcucumber.options="-t @Smoke"`

### Run multiple parameters

`mvn test `

`-Dcucumber.options="...."`

`-Dcucumber.options="...."`
