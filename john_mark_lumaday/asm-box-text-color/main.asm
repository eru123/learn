.model small
.stack 100h
.data
txt db 10, 13, '    RED', 10, 13, 10, 13, 10, 13, '              GREEN',10, 13, 10, 13, 10, 13, '                         BLUE', 10, 13, 10, 13, 10, 13, 10, 13, '$'

.code
main proc
    call draw_box
    call write_text
    
    ; exit
    mov ax, 4c00h
    int 21h

    ret
main endp

draw_box proc near
    ; set cursor to (0,0)
    mov ah, 6
    
    ; red box
    mov al, 0
    mov bh, 74h
    mov ch, 0
    mov cl, 0
    mov dh, 2d
    mov dl, 10d
    int 10h

    ; green box
    mov al, 0
    mov bh, 72h
    mov ch, 3d
    mov cl, 11d
    mov dh, 5d
    mov dl, 21d
    int 10h

    ; blue box
    mov al, 0
    mov bh, 71h
    mov ch, 6d
    mov cl, 22d
    mov dh, 8d
    mov dl, 32d
    int 10h
    
    ret
draw_box endp

write_text proc near
    ; set to text mode
    mov ah, 3
    mov al, 0
    mov bh, 0
    int 10h
    
    ; get data
    mov ax, @data
    mov ds, ax
    
    ; print text
    mov al, 0
    lea dx, txt
    mov ah, 09
    int 21h
    
    ret
write_text endp
end main