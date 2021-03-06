USE [BD]
GO
/****** Object:  StoredProcedure [dbo].[AnimaleDEL]    Script Date: 16-Jan-18 1:50:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[AnimaleDEL]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'
-- =============================================
-- Author:		Vlad HULEA
-- Create date: 13/01/2018
-- Description:	Create delet stored procedure
-- =============================================
ALTER PROCEDURE [dbo].[AnimaleDEL] 
(
	@id_animal			[INT]
)
AS
BEGIN
	SET NOCOUNT ON;
  
    DELETE FROM [dbo].[Animale]
		WHERE [dbo].[Animale].[id_animal] = @id_animal
		
END
' 
END