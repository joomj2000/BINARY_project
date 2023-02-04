# dataset 폴더 생성 후 실행
import cv2

# 분석 모델
faceCascade = cv2.CascadeClassifier('.\haarcascade_frontalface_default.xml')

# 카메라 세팅
cam = cv2.VideoCapture(0) # 내장카메라 == 0, 외장 == 1
# 3:4 카메라
cam.set(cv2.CAP_PROP_FRAME_WIDTH, 1280)
cam.set(cv2.CAP_PROP_FRAME_HEIGHT, 720)

face_id = input('\n enter user id end press <return> ==> ') # 사용자 id 입력
print('\n Initializing face capture. Look the camera and waith . . .')

# 사진 count
cnt = 0

# 영상 처리 및 출력
while True:

    # 카메라 상태 및 프레임
    # 카메라가 정상이면 ret == True
    ret, frame = cam.read()

    # cf. frame = cv2.flip(frame, -1) 상하반전

    # haar cascade는 흑백으로 처리
    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)

    # 추후에 설명 추가
    faces = faceCascade.detectMultiScale(
        gray, # 검출 하고 싶은 원본 이미지
        scaleFactor = 1.2, # 검색 윈도우 확대 비율, 1보다 커야 함
        minNeighbors = 6,  # 얼굴 사이 최소 간격 (픽셀값)
        minSize = (20, 20) # 얼굴 최소 크기 / 이 사이즈보다 작으면 무시
    )

    # 얼굴 rectangle
    for (x, y, w, h) in faces:
        cv2.rectangle(frame, (x, y), (x+w, y+h), (255, 0, 0), 2)
        cnt += 1
        cv2.imwrite('dataset/User.' + str(face_id) + '. (' + str(cnt) + ').jpg', gray[y:y+h, x:x+w])

    # cv2.imshow('image', frame)

    # 종료 조건
    if cv2.waitKey(1) > 0 : break
    elif cnt >= 100 : break

print("\n [INFO] Exiting Program and cleanup stuff")

cam.release() #메모리 해제
cv2.destroyAllWindows()#모든 윈도우 창 닫기