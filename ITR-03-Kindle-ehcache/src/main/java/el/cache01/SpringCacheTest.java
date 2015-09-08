package el.cache01;

import java.io.IOException;

import junit.framework.Assert;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;

import org.junit.Test;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.core.io.ClassPathResource;

public class SpringCacheTest {

   @Test
   public void test() throws CacheException, IOException {
      // Native CacheManager 
      CacheManager nativeEhcacheManager = new CacheManager(new ClassPathResource("ehcache.xml").getInputStream());

      // Create spring wrapped CacheManager
      EhCacheCacheManager springWrappedEhcacheCacheManager = new EhCacheCacheManager();
      springWrappedEhcacheCacheManager.setCacheManager(nativeEhcacheManager);
      
      Long id = 1L;  
      User user = new User(id, "zhang", "zhang@gmail.com");
      
      Cache cache = springWrappedEhcacheCacheManager.getCache("user");
      cache.put(id, user); 
      User u = cache.get(id, User.class);
      System.out.println(u);
      Assert.assertNotNull(u);

   }
}
