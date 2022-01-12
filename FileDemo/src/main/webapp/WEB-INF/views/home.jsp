<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../resources/css/teamA.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>File Upload</title>
</head>
<style>
@charset "UTF-8";

:root { -
	-main-color: #4D5EB3; /*dark blue*/ -
	-sub-color: #FFD44A; /*yellow*/ -
	-grey-color: #959595;
}

@font-face {
	font-family: 'Cafe24SsurroundAir';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2105_2@1.0/Cafe24SsurroundAir.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}
/* start page */
body {
	height: 100vh;
	font-family: 'Cafe24SsurroundAir';
}

.top {
	height: 20vh;
	margin-top: 5vh;
}
.bg-title {
	background-color: #4D5EB3;
}

.middle {
	height: 40vh;
}

.bottom {
	padding-top: 10vh;
}

footer {
  color: white;
  background-color: #4D5EB3;
  width: 100%;
  position: absolute;
  bottom: 0;
  left:0;
}
}
</style>
<body>
	<div class="container-fluid">
		<div class="row text-center">
			<div class="col">1 of 3</div>
			<div class="col">
				<div class="top">
					<div class="badge bg-title px-5 py-3">파일 업로드 예제</div>
				</div>
				<div class="middle">
					<div class="text-center my-3">
						<div class="my-5">
							<p>이미지 파일용</p>
							<input class="form-control file" type="file" id="imagefile"
								name="imagefile" accept="image/*" multiple>
						</div>
						<div class="my-5">
							<p>모든 파일용</p>
							<input class="form-control file" type="file" id="imagefile"
								name="imagefile" multiple>
						</div>
					</div>
				</div>
			</div>
			<div class="col">3 of 3</div>

		</div>
	</div>
	<footer class="text-center py-3">
		<span class="align-middle">@2022 Web Service 양지후, 이지슬</span>
	</footer>
</body>
</html>