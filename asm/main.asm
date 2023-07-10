.model small
.stack 100h
.data
txt db 10, 13, '    RED', 10, 13, 10, 13, 10, 13, '              GREEN',10, 13, 10, 13, 10, 13, '                         BLUE', 10, 13, 10, 13, 10, 13, 10, 13, '$'

.code
main proc
    call draw_box               ; call draw_box procedure
    call write_text             ; call write_text procedure
    
    ; exit
    mov ax, 4c00h
    int 21h
    ret
main endp

; draw_box procedure
draw_box proc near
    ; set cursor to (0,0)
    mov ah, 6
    
    ; draw red box
    mov al, 0               ; number of characters to write
    mov bh, 74h             ; set bg color to 7 (gray) and fg color to 4 (red) 
                            ; h means hexadecimal
                            ; 7 is the hexadecimal value of gray
                            ; 4 is the hexadecimal value of red
    mov ch, 0               ; y coordinate
    mov cl, 0               ; x coordinate
    mov dh, 2d              ; height
    mov dl, 10d             ; width
    int 10h                 ; bios call or interrupt
                            ; draw the box

    ; draw green box
    mov al, 0               ; number of characters to write
    mov bh, 72h             ; set bg color to 7 (gray) and fg color to 2 (green)
                            ; h means hexadecimal
                            ; 7 is the hexadecimal value of gray
                            ; 2 is the hexadecimal value of green
    mov ch, 3d              ; y coordinate
    mov cl, 11d             ; x coordinate
    mov dh, 5d              ; height
    mov dl, 21d             ; width
    int 10h                 ; bios call
                            ; draw the box

    ; draw blue box
    mov al, 0               ; number of characters to write
    mov bh, 71h             ; set bg color to 7 (gray) and fg color to 1 (blue)
                            ; h means hexadecimal
                            ; 7 is the hexadecimal value of gray
                            ; 1 is the hexadecimal value of blue
    mov ch, 6d              ; y coordinate
    mov cl, 22d             ; x coordinate
    mov dh, 8d              ; height
    mov dl, 32d             ; width
    int 10h                 ; bios call
                            ; draw the box
    
    ret                     ; return
draw_box endp

; write_text procedure
write_text proc near
    ; set to text mode
    mov ah, 3               ; set to text mode
    mov al, 0               ; number of characters to write
    mov bh, 0               ; set color to default
    int 10h                 ; bios call
    
    ; get data
    mov ax, @data           ; get address of data
    mov ds, ax              ; set ds to data segment
    
    ; print text
    mov al, 0               ; number of characters to write
    lea dx, txt             ; get address of txt
    mov ah, 09              ; print text
    int 21h                 ; bios call
    
    ret                     ; return
write_text endp 
end main                    ; end of program
                            ; main is the entry point