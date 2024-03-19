package com.goormTable.call.service;

import com.goormTable.call.dto.CallReservationData;
import com.goormTable.call.repository.CallRepository;
import com.goormTable.member.entity.Reservation;
import lombok.RequiredArgsConstructor;
import net.nurigo.sdk.NurigoApp;

import net.nurigo.sdk.message.exception.NurigoEmptyResponseException;
import net.nurigo.sdk.message.exception.NurigoMessageNotReceivedException;
import net.nurigo.sdk.message.exception.NurigoUnknownException;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.service.DefaultMessageService;
import net.nurigo.sdk.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CallService {

    @Autowired
    private CallRepository callRepository;
    private CallReservationData callReservationData = CallReservationData.getInstance();

    @Value("${PHONE-NUMBER}")
    private String fromNum;
    @Value("${API-KEY}")
    private String apikey;
    private String secretkey;
    DefaultMessageService messageService =  NurigoApp.INSTANCE.initialize("API 키 입력", "API 시크릿 키 입력", "https://api.solapi.com");
    // Message 패키지가 중복될 경우 net.nurigo.sdk.message.model.Message로 치환하여 주세요


    public Message setMessage(Message message, String from, String to, String context) {
        message.setFrom(from);
        message.setTo(to);
        message.setText(context);
        return message;
    }

    public boolean CallReservation(String phone_num, int member_seq) {
        Optional<Reservation> reservationOptional = callRepository.findByMember_MemberSeqAndPhoneNum(member_seq, phone_num);
        if (reservationOptional.isPresent()) {
            Reservation reservation = reservationOptional.get();
            reservation.setStatus("call");
            callReservationData.addReservation(reservation);
            callRepository.save(reservation);
            sendMessage(phone_num);
            return true;
        }
        else {
            return false;
        }
    }

    public void sendMessage(String phone_num) {
        Message message = new Message();
        String context = "호출되었습니다.";
        message = setMessage(message, fromNum, phone_num, context);
        try {
            messageService.send(message);
        } catch (NurigoMessageNotReceivedException e) {
            throw new RuntimeException(e);
        } catch (NurigoEmptyResponseException e) {
            throw new RuntimeException(e);
        } catch (NurigoUnknownException e) {
            throw new RuntimeException(e);
        }
    }
}
