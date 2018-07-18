import * as nodemailer from 'nodemailer';

export class SendMail {
    sendMail() {
        const transporter = nodemailer.createTransport({
            service: 'gmail',
            auth: {
                user: 'carelearning.contact@gmail.com',
                pass: '######',
            },
        });

        const mailOptions = {
            from: 'carelearning.contact@gmail.com',
            to: 'lucile.1988.ls@gmail.com',
            subject: 'Test',
            html: '<p>Hello World</p>'
        };

        const randomPassword = Math.random().toString(20).substring(2, 15);

        console.log(randomPassword);

        transporter.sendMail(mailOptions, function(err, info) {
            if (err)
                console.log(err);
            else
                console.log(info);

        });
    }
}