package com.happysat.whatsapp_clone.service;

import com.happysat.whatsapp_clone.exception.ChatException;
import com.happysat.whatsapp_clone.exception.UserException;
import com.happysat.whatsapp_clone.modal.Chat;
import com.happysat.whatsapp_clone.modal.User;
import com.happysat.whatsapp_clone.request.GroupChatRequest;

import java.util.List;

public interface ChatService {

    public Chat createChat(User reqUser, Integer userId2) throws UserException;

    public Chat findChatById(Integer chatId) throws ChatException;

    public List<Chat> findAllChatByUserId(Integer userId) throws UserException;

    public Chat createGroup(GroupChatRequest req, Integer reqUserId) throws UserException;

    public Chat addUserToGroup(Integer userID, Integer chatId) throws UserException, ChatException;

    public Chat renameGroup(Integer chatId, String groupName, Integer reqUserId) throws ChatException, UserException;

    public Chat removeFromGroup(Integer chatId, Integer userId, Integer reqUser) throws UserException, ChatException;

    public Chat deleteChat(Integer chatId, Integer userId) throws ChatException, UserException;
}
