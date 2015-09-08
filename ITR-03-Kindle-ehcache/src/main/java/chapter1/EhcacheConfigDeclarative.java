package chapter1;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;

public class EhcacheConfigDeclarative {

   private static final String EHCACHE_CONFIG = "src/main/resources/ehcache.xml";
   private static final String CACHE_NAME     = "objectCache";

   public static void main(String[] args) {
      CacheManager manager = new CacheManager(EHCACHE_CONFIG);
      Ehcache cache = manager.getCache(CACHE_NAME);
   }
}
