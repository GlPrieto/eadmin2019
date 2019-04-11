package es.fpdual.primero.eadmin.mapper;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-configuration/eadmin-sqlserver-persistencia.xml",
		"classpath:spring-configuration/eadmin-persistencia.xml" })

public class SQLServerDocumentoMapperTest extends BaseDocumentoMapperTest {

}
