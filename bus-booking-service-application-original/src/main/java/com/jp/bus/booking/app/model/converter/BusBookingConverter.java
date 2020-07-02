package com.jp.bus.booking.app.model.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.jp.bus.booking.app.entity.Bus;
import com.jp.bus.booking.app.entity.BusBooking;
import com.jp.bus.booking.app.model.BusBookingSummaryModel;

@Component
public class BusBookingConverter implements Converter<BusBooking, BusBookingSummaryModel> {

	@Override
	public BusBookingSummaryModel convert(BusBooking source) {
		Bus flight = CollectionUtils.isEmpty(source.getBuses()) ? new Bus()
				: (Bus) source.getBuses().toArray()[0];
		return new BusBookingSummaryModel(source.getId(), source.getPassenger().getLastName(),
				flight.getDeparture());
	}

}
