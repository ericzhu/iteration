package ca.el.ecom.core;

import javax.transaction.Transactional;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"ecom-core-test-context.xml"})
@Transactional
@Rollback(true)
public abstract class BaseIntegrationTests {
   
}
