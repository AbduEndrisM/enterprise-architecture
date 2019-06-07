Changed spring-boot-starter-parent version to 2.1.5.RELEASE, it causes very strange error.
Which @Size externalized error message, cannot be able to resolve placeholder like {0}
{1}, {2}, just display the text in properties file.

It's not an issue in 2.1.4.RELEASE.
<parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.4.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>