����   2 ^ 'com/dacodes/censos/data/models/DateItem  java/lang/Object  title Ljava/lang/String; $Lorg/jetbrains/annotations/Nullable; getTitle ()Ljava/lang/String;  	  
 this )Lcom/dacodes/censos/data/models/DateItem; setTitle (Ljava/lang/String;)V <set-?> date getDate  	   setDate <init> '(Ljava/lang/String;Ljava/lang/String;)V ()V  
   V(Ljava/lang/String;Ljava/lang/String;ILkotlin/jvm/internal/DefaultConstructorMarker;)V java/lang/String   
    
    
component1 
component2 copy O(Ljava/lang/String;Ljava/lang/String;)Lcom/dacodes/censos/data/models/DateItem; #Lorg/jetbrains/annotations/NotNull; copy$default �(Lcom/dacodes/censos/data/models/DateItem;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Object;)Lcom/dacodes/censos/data/models/DateItem; $ %
  ) toString java/lang/StringBuilder ,
 -  DateItem(title= / append -(Ljava/lang/String;)Ljava/lang/StringBuilder; 1 2
 - 3 , date= 5 ) 7 + 	
 - 9 hashCode ()I ; <
  = equals (Ljava/lang/Object;)Z kotlin/jvm/internal/Intrinsics A areEqual '(Ljava/lang/Object;Ljava/lang/Object;)Z C D
 B E Lkotlin/Metadata; mv       bv        k d1��"

��
��





��20B
0
0¢J0HÆJ0HÆJ!0��2
02
0HÆJ020HÖJ	0HÖJ	0HÖR0X¢
��"	R0X¢
��
"	¨ d2   other 	app_debug DateItem.kt RuntimeInvisibleAnnotations Code LineNumberTable LocalVariableTable $RuntimeInvisibleParameterAnnotations StackMapTable 
SourceFile RuntimeVisibleAnnotations 1          V            V           	  W   /     *� �    X       ! Y            V            W   :     *+� �    X       ! Y                  Z          	  W   /     *� �    X       " Y            V            W   :     *+� �    X       " Y                  Z            W   M     *� *+� *,� �    X         Y                         Z               W   C     ~� � L~� � M*+,� �    [    
 X   
   !  "