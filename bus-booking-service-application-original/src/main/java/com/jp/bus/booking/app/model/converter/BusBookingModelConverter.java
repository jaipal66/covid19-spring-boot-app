package com.jp.bus.booking.app.model.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.jp.bus.booking.app.entity.BusBooking;
import com.jp.bus.booking.app.model.BusBookingModel;
import com.jp.bus.booking.app.model.BusModel;
import com.jp.bus.booking.app.model.PassengerModel;

@Component
public class BusBookingModelConverter implements Converter<BusBooking, BusBookingModel> {

	@Override
	public BusBookingModel convert(BusBooking source) {
		
		List<BusModel> buses = new ArrayList<>();

		if (!CollectionUtils.isEmpty(source.getBuses())) {
			source.getBuses().stream().forEach(bus -> {
				buses.add(new BusModel(bus.getId(),bus.getBusNumber(),bus.getOperatorName(),bus.getDeparture(), bus.getArrival(),
						bus.getDepartureTime().toString(), bus.getArrivalTime().toString()));
			});
		}

		return new BusBookingModel(source.getId(), new PassengerModel(source.getPassenger().getFirstName(),
				source.getPassenger().getLastName(), source.getPassenger().getEmail()), buses);
	}

}
