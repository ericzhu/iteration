package chapter2;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.exceptionhandler.CacheExceptionHandler;

public class CustomExceptionHandler implements CacheExceptionHandler {

   @Override
   public void onException(Ehcache arg0, Object arg1, Exception arg2) {
      
   }

}
