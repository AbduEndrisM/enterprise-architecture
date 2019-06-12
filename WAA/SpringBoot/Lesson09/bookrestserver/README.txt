This demo is for lesson: Lesson Spring REST & AJAX. This is server side.

1. For custom validation error message, you need to do:
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>

@Bean
public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource
      = new ReloadableResourceBundleMessageSource();

    messageSource.setBasename("classpath:messages");
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;
}

@Bean
public LocalValidatorFactoryBean getValidator() {
    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
    bean.setValidationMessageSource(messageSource());
    return bean;
}

2. To use HATEOAS:
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-hateoas</artifactId>
</dependency>

Resource<Category> resource = new Resource<>(category);
        ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(
                ControllerLinkBuilder.methodOn(this.getClass()).retrieveAllCategories()
);

resource.add(linkTo.withRel("all-categories"));


3. Support XML
   <dependency>
            <groupId>com.fasterxml.jackson.dataformat</groupId>
            <artifactId>jackson-dataformat-xml</artifactId>
   </dependency>


3. To enable Cross-Origin-Resource-Sharing (CORS), use @CrossOrigin(origins = { "http://localhost:9080", "http://localhost:9000" }, maxAge = 6000)
