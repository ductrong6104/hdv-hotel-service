CREATE PROCEDURE [dbo].[sp_find_bedTypes_by_hotelId](@hotelId int)
AS
BEGIN
	select bt.id, bt.bedTypeName from bedType bt
	where bt.id in
	(select rc_bt.idBedType
	from roomClass_bedType rc_bt
	where rc_bt.idHotelRoomClass in
		(SELECT hrc.id
		FROM hotel_roomClass hrc
		WHERE hrc.idHotel = @hotelId))
END