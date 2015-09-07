package ca.el.ecom.extension.common.utils;

public class Message {

   public enum Type {
      success,
      warning,
      error
   }

   private Type   type;
   private String content;

   public Message() {

   }

   public Message(Type type, String content) {
      this.type = type;
      this.content = content;
   }

   public Message(Type type, String content, Object... args) {
      this.type = type;
      this.content = content;
   }

   public static Message success(String content, Object... args) {
      return new Message(Type.success, content, args);
   }

   public static Message warning(String content, Object... args) {
      return new Message(Type.warning, content, args);
   }

   public static Message error(String content, Object... args) {
      return new Message(Type.error, content, args);
   }

   public Type getType() {
      return type;
   }

   public void setType(Type type) {
      this.type = type;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }
}
