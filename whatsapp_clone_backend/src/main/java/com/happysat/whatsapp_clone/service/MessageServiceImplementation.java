package com.happysat.whatsapp_clone.service;

import com.happysat.whatsapp_clone.exception.ChatException;
import com.happysat.whatsapp_clone.exception.MessageException;
import com.happysat.whatsapp_clone.exception.UserException;
import com.happysat.whatsapp_clone.modal.Chat;
import com.happysat.whatsapp_clone.modal.Message;
import com.happysat.whatsapp_clone.modal.User;
import com.happysat.whatsapp_clone.repository.MessageRepository;
import com.happysat.whatsapp_clone.request.SendMessageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImplementation implements MessageService{

    private UserService userService;
    private MessageRepository messageRepository;
    private ChatService chatService;

    public MessageServiceImplementation(UserService userService, MessageRepository messageRepository, ChatService chatService) {
        this.userService = userService;
        this.messageRepository = messageRepository;
        this.chatService = chatService;
    }

    @Override
    public Message sendMessage(SendMessageRequest req) throws UserException, ChatException {
        User user = userService.findUserById(req.getUserId());
        Chat chat = chatService.findChatById(req.getChatId());

        Message message = new Message();
        message.setChat(chat);
        message.setUser(user);
        message.setContent(req.getContent());
        message.setTimestamp(LocalDateTime.now());

        return message;
    }

    @Override
    public List<Message> getChatMessages(Integer chatId, User reqUser) throws ChatException, UserException {
        Chat chat = chatService.findChatById(chatId);
        if(!chat.getUsers().contains(reqUser)){
            throw new UserException("you are not a member of this chat: " +chat.getId());
        }
        List<Message> messages = messageRepository.findByChatId(chat.getId());

        return messages;
    }

    @Override
    public Message findMessageById(Integer messageId) throws MessageException {
        Optional<Message> opt = messageRepository.findById(messageId);
        if(opt.isPresent()){
            return opt.get();
        }
        throw new MessageException("Message not found with id: " +messageId);
    }

    @Override
    public void deleteMessage(Integer messageId, User reqUser) throws MessageException, UserException {
        Message message = findMessageById(messageId);

        if(message.getUser().getId().equals(reqUser.getId())){
            messageRepository.deleteById(messageId);
        }
        throw new UserException("you can't delete another user message" +reqUser.getFull_name());
    }
}
