import * as nodemailer from 'nodemailer';
import * as fs from 'fs';
import * as handlebars from 'handlebars';

export class MailSender {
    private templateDirectory: string = './src/mail/template/html';

    static MAIL_TEMPLATE = {
        SEND_PASSWORD: { fileName: 'sendPassword.html', subject: 'Heureux de vous accueillir :) !' },
    };

    sendMail(template: any, context: any) {
        const templatePath = this.templateDirectory + '/' + template.fileName;
        fs.readFile(templatePath, 'utf8', (error, data) => {
            const templateCompiled = handlebars.compile(data);
            const html = templateCompiled(context);
            this.sendTemplate(html, template, context);
        });
    }

    private sendTemplate(mailTemplate: string, template: any, context: any) {
        const transporter = nodemailer.createTransport({
            service: 'gmail',
            auth: {
                user: process.env.CARELEARNING_MAIL,
                pass: process.env.CARELEARNING_PWD,
            },
        });

        const mailOptions = {
            from: process.env.CARELEARNING_MAIL,
            to: context.mailTo,
            subject: template.subject,
            html: mailTemplate,
        };

        transporter.sendMail(mailOptions, function (err, info) {
            if (err)
                console.log(err);
            else
                console.log(info);

        });
        transporter.close();
    }
}