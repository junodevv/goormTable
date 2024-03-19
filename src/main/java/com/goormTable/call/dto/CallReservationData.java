package com.goormTable.call.dto;

import com.goormTable.member.entity.Reservation;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CallReservationData {
    private List<Reservation> reservationList = new ArrayList<>();

    // 싱글톤 인스턴스
    private static final CallReservationData instance = new CallReservationData();

    // private 생성자를 사용하여 외부에서 인스턴스를 생성하지 못하도록 함
    private CallReservationData() {}

    // 싱글톤 인스턴스에 접근하기 위한 public 메소드
    public static CallReservationData getInstance() {
        return instance;
    }

    // 예약 목록에 예약 추가
    public void addReservation(Reservation reservation) {
        reservationList.add(reservation);
    }

    // 예약 목록에서 예약 제거
    public void removeReservation(Reservation reservation) {
        reservationList.remove(reservation);
    }

    // 예약 목록 초기화
    public void clearReservations() {
        reservationList.clear();
    }
}