-- ================================================
-- Template generated from Template Explorer using:
-- Create Procedure (New Menu).SQL
--
-- Use the Specify Values for Template Parameters 
-- command (Ctrl-Shift-M) to fill in the parameter 
-- values below.
--
-- This block of comments will not be included in
-- the definition of the procedure.
-- ================================================
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Vlad Hulea
-- Create date: 17.01.2018
-- Description:	
-- =============================================
CREATE PROCEDURE VeterinariSEARCH 
	-- Add the parameters for the stored procedure here
	
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT V.id_veterinar
			,V.nume_v
			,V.prenume_v
			,V.adresa_v
			,V.email_v
			,V.telefon_v
			
	FROM Veterinari AS V 
END
GO
