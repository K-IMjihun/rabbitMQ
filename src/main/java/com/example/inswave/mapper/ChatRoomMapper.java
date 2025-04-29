package com.example.inswave.mapper;

import com.example.inswave.chat.model.ChatRoom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ChatRoomMapper {
    List<ChatRoom> getChatRoomPaging(@Param("start") int start, @Param("end") int end);
}
