package com.happysat.whatsapp_clone.service;

import com.happysat.whatsapp_clone.exception.ChatException;
import com.happysat.whatsapp_clone.exception.UserException;
import com.happysat.whatsapp_clone.modal.Chat;
import com.happysat.whatsapp_clone.modal.User;
import com.happysat.whatsapp_clone.repository.ChatRepository;
import com.happysat.whatsapp_clone.request.GroupChatRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImplementation implements ChatService{

    private ChatRepository chatRepository;
    private UserService userService;

    public ChatServiceImplementation(ChatRepository chatRepository, UserService userService){
        this.chatRepository = chatRepository;
        this.userService = userService;
    }

    @Override
    public Chat createChat(User reqUser, Integer userId2) throws UserException {
        User user = userService.findUserById(userId2);
        Chat isChatExist = chatRepository.findSingleChatByUserIds(user, reqUser);

        if(isChatExist != null){
            return isChatExist;
        }

        Chat chat = new Chat();
        chat.setCreatedBy(reqUser);
        chat.getUsers().add(user);
        chat.getUsers().add(reqUser);
        chat.setGroup(false);

        return chat;
    }

    @Override
    public Chat findChatById(Integer chatId) throws ChatException {
        return null;
    }

    @Override
    public List<Chat> findAllChatByUserId(Integer userId) throws UserException {
        return List.of();
    }

    @Override
    public Chat createGroup(GroupChatRequest req, Integer reqUserId) throws UserException {
        return null;
    }

    @Override
    public Chat addUserToGroup(Integer userID, Integer chatId) throws UserException, ChatException {
        return null;
    }

    @Override
    public Chat renameGroup(Integer chatId, String groupName, Integer reqUserId) throws ChatException, UserException {
        return null;
    }

    @Override
    public Chat removeFromGroup(Integer chatId, Integer userId, Integer reqUser) throws UserException, ChatException {
        return null;
    }

    @Override
    public Chat deleteChat(Integer chatId, Integer userId) throws ChatException, UserException {
        return null;
    }
}
