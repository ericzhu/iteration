package chapter2;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.exceptionhandler.ExceptionHandlingDynamicCacheProxy;

public class EventAndExceptionHandler {
   private static final String EHCACHE_CONFIG = "src/main/resources/ehcache.xml";
   private static final String CACHE_NAME     = "objectCache";

   public static void main(String[] args) {
      CacheManager manager = new CacheManager(EHCACHE_CONFIG);
      Ehcache cache = manager.getCache(CACHE_NAME);

      // register the custom event listener
      cache.getCacheEventNotificationService().registerListener(new CustomEventListener());

      // set custom exception handler
      cache.setCacheExceptionHandler(new CustomExceptionHandler());

      // create cache proxy
      Ehcache proxiedCache = ExceptionHandlingDynamicCacheProxy.createProxy(cache);
      // replace default with decorated cache
      manager.replaceCacheWithDecoratedCache(cache, proxiedCache);
   }
}
