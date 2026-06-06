# HIS API Documentation

## User Module

### POST /api/user/login
User login
- Body: `{ "username": "admin", "password": "123456" }`

### GET /api/user/info
Get user info
- Headers: `Authorization: Bearer <token>`

### GET /api/user/doctors
Get doctor list

### GET /api/nurses
Get nurse list

## Patient Module

### GET /api/patient/list
Query patients with pagination
- Params: `page`, `size`, `keyword`

### GET /api/patient/{id}
Get patient detail

### POST /api/patient
Create patient
- Body: `{ "name": "...", "gender": "M/F", "age": 30, ... }`

### PUT /api/patient/{id}
Update patient

### DELETE /api/patient/{id}
Delete patient

### GET /api/patient/inpatients
Get inpatients

## Doctor Module

### GET /api/doctor/list
Get doctor list
- Params: `departmentId` (optional)

### GET /api/doctor/appointments/today
Get today appointments
- Params: `doctorId`

### GET /api/doctor/schedule
Get doctor schedule
- Params: `doctorId`, `startDate`, `endDate`

### POST /api/doctor/call-next
Call next patient
- Params: `doctorId`

### POST /api/doctor/complete/{id}
Complete appointment

## Nurse Module

### GET /api/nurse/list
Get nurse list
- Params: `departmentId` (optional)

### GET /api/nurse/schedule
Get schedule
- Params: `staffId`, `startDate`, `endDate`

### POST /api/nurse/schedule
Add schedule

### GET /api/nurse/care-records
Get care records
- Params: `patientId`

### POST /api/nurse/care-records
Add care record

### GET /api/nurse/medications/today
Get today medications
- Params: `nurseId` (optional)

### POST /api/nurse/medications/{id}/execute
Execute medication
- Params: `nurseId`, `remark` (optional)
