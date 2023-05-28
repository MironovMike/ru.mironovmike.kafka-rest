# .m2/settings.xml example
```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 https://maven.apache.org/xsd/settings-1.0.0.xsd">
	<profiles>
		<profile>
			<id>default</id>
			<activation>
				<activeByDefault>true</activeByDefault>
			</activation>
			<properties>
				<docker-registry>alpha.mironovmike.ru:5000</docker-registry>
				<docker-registry.user>your_registry_user</docker-registry.user>
				<docker-registry.password>your_registry_password</docker-registry.password>
			</properties>
		</profile>
	</profiles>
</settings>
```