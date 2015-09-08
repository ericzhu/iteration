package chapter1;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.Configuration;

public class EhcacheConfigProgrammatic {

   private static final String EHCACHE_CONFIG = "src/main/resources/ehcache.xml";
   private static final String CACHE_NAME     = "objectCache";

   public static void main(String[] args) {
      Configuration cacheManagerConfiguration = new Configuration();
      CacheConfiguration cacheConfiguration = new CacheConfiguration("objectCache", 100).eternal(true).maxEntriesLocalHeap(100);
      cacheManagerConfiguration.addCache(cacheConfiguration);
      CacheManager manager = new CacheManager(cacheManagerConfiguration);
      Ehcache cache = manager.getEhcache("objectCache");
   }
}
